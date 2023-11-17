package com.example.pratica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Crie as requisições em arquivos HTTP no IntelliJ para testar os métodos criados para a API.

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {
    private List<Transacao> transacoes = new ArrayList<>();


    private final TransacaoRepository transacaoRepository;

        @Autowired
        public TransacaoController(TransacaoRepository transacaoRepository){
            this.transacaoRepository = transacaoRepository;
        }

    //Cadastrar uma nova transação
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarTransacao(@RequestBody Transacao transacao) {
        transacaoRepository.save(transacao);
        return ResponseEntity.ok("Cadastro realizado com sucesso");
    }

    //Listar todas as transações
    @GetMapping("/listar")
        public List<Transacao> listarProdutos() {
            return transacaoRepository.findAll();
        }

    //Buscar transações por tipo_transacao

    @GetMapping("/buscar/{tipoTransacao}")
    public ResponseEntity<String> selecionarPorTipoTransacao(@PathVariable Long id,
                                                             @RequestParam String tipoTransacao) {
        Optional<Transacao> transacaoExistente = transacaoRepository.findById(id);
        if (transacaoExistente.isPresent()) {
            Transacao transacao = transacaoExistente.get();
            transacao.setTipoTransacao(tipoTransacao);

            transacaoRepository.save(transacao);
            return ResponseEntity.ok("Transação atualizada com sucesso");
        }else{
            return ResponseEntity.ok().build();
        }
    }


    //Atualizar as informações descricao, valor ou tipo_transacao de uma transação por id

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarTransacao(@PathVariable Long id,
                                                   @RequestBody Transacao transacaoAtualizada) {
        Optional<Transacao> transacaoExistente = transacaoRepository.findById(id);
        if (transacaoExistente.isPresent()) {
            Transacao transacao = transacaoExistente.get();
            transacao.setDescricao(transacaoAtualizada.getDescricao());
            transacao.setDataTransacao(transacaoAtualizada.getData_transacao());
            transacao.setValor(transacaoAtualizada.getValor());
            transacao.setTipoTransacao(transacaoAtualizada.getTipoTransacao());

            transacaoRepository.save(transacao);
            return ResponseEntity.ok("Transacao atualizada com sucesso");

        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Excluir transação pelo id
    @DeleteMapping("/excluir/{id}")
        public ResponseEntity<String> excluirTransacao(@PathVariable Long id) {
            transacaoRepository.deleteById(id);
            return ResponseEntity.ok("Transação excluída com sucesso");
        }
    }