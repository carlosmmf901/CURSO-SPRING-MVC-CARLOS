package com.firstAPI.firstAPI.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.firstAPI.firstAPI.exception.ResourceNotFoundException;
import com.firstAPI.firstAPI.model.PessoaModel;
import com.firstAPI.firstAPI.repository.PessoaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaController pessoaController;

    @Test
    public void testCadastroPessoa() throws ResourceNotFoundException {

        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setNome("Maria12");
        pessoaModel.setEmail("maria@example.com");
        pessoaModel.setCpf("12345678900");

        when(pessoaRepository.save(pessoaModel)).thenReturn(pessoaModel);

        String cadastroMessage = pessoaController.cadastroPessoa(pessoaModel);

        assertEquals("A pessoa Maria12 foi cadastrada", cadastroMessage);
    }

    @Test
    public void listarUsuariosTest() throws ResourceNotFoundException {
        List<PessoaModel> listaTodosUsuarios = new ArrayList<>();

        when(pessoaRepository.findAll()).thenReturn(listaTodosUsuarios);

        Iterable resultadoLista = pessoaController.buscaUsuarios();

        assertEquals(listaTodosUsuarios, resultadoLista);

    }





    @Test
    public void buscarUsuarioPeloIdTest_SeExiste() throws ResourceNotFoundException {

        long idTeste = 103; //ID de teste

        //Pessoa que o teste esperar encontrar

        PessoaModel pessoaModelEsperadoTeste = new PessoaModel();
        pessoaModelEsperadoTeste.setId(103);
        pessoaModelEsperadoTeste.setNome("UsuarioTeste");
        pessoaModelEsperadoTeste.setEmail("UsuarioTeste@gmail.com");
        pessoaModelEsperadoTeste.setCpf("999.999.999-99");


        //Simular a chamada do metodo findById
        when(pessoaRepository.findById(idTeste)).thenReturn(Optional.of(pessoaModelEsperadoTeste));

        ResponseEntity<PessoaModel> response = pessoaController.buscarUsuarioPeloID(idTeste);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(pessoaModelEsperadoTeste, response.getBody());

    }


    @Test
    public void buscarUsuarioPeloIdTest_SeNaoExiste() throws ResourceNotFoundException {
        //ID simulado
        long idTeste = 999999;

        when(pessoaRepository.findById(idTeste)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            pessoaController.buscarUsuarioPeloID(idTeste);
        });

        assertEquals("Não existe pessoa com o ID: " + idTeste, exception.getLocalizedMessage());

    }

    @Test
    public void editarPessoaTeste() throws ResourceNotFoundException {
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(1L);
        pessoaModel.setNome("Maria");
        pessoaModel.setEmail("maria@example.com");
        pessoaModel.setCpf("12345678900");

        when(pessoaRepository.findById(pessoaModel.getId())).thenReturn(Optional.of(pessoaModel));

        String result = pessoaController.alterarPessoa(pessoaModel);

        assertEquals("Maria Foi Alterado", result);
    }

    @Test
    public void meuPrimeiroPostTest() throws ResourceNotFoundException {
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setMeuTexto("texto test");

        when(pessoaRepository.save(pessoaModel)).thenReturn(pessoaModel);

        String cadastroMessage = pessoaController.meuPrimeiroPost(pessoaModel);

        assertEquals("O texto enviado foi:texto test", cadastroMessage);

    }

    @Test
    public void deletarPessoaTeste() throws ResourceNotFoundException {
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId(1L);
        pessoaModel.setNome("Maria");
        pessoaModel.setEmail("maria@example.com");
        pessoaModel.setCpf("12345678900");

        when(pessoaRepository.findById(pessoaModel.getId())).thenReturn(Optional.of(pessoaModel));

        String result = pessoaController.deletarPessoa(pessoaModel.getId());

        assertEquals("MariaDeletado", result);
    }


}
