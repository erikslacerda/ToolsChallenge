package com.tools.crm.service.impl;

import com.tools.crm.convert.RequisicaoConverter;
import com.tools.crm.dto.RequisicaoPagamentoDTO;
import com.tools.crm.dto.RespostaPagamentoDTO;
import com.tools.crm.exception.ResourceNotFoundException;
import com.tools.crm.model.Pagamento;
import com.tools.crm.model.Status;
import com.tools.crm.repository.PagamentoRepository;
import com.tools.crm.service.PagamentoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagamentoServiceImpl implements PagamentoServico {

    @Autowired
    private PagamentoRepository pagamentoRepositorio;

    @Autowired
    private RequisicaoConverter requisicaoConverter;

    @Override
    public RespostaPagamentoDTO realizarPagamento(RequisicaoPagamentoDTO requisicaoPagamentoDTO) {
        Pagamento pag = requisicaoConverter.convertToRequisicaoPagamento(requisicaoPagamentoDTO);

        pag.setNsu(1234);
        pag.setStatus(Status.AUTORIZADO);
        pag.setCondigoAutorizacao(1111111);
        Pagamento pagamento = pagamentoRepositorio.save(pag);
        RespostaPagamentoDTO respostaPagamentoDTO = new RespostaPagamentoDTO();
        String cartaoNovo = this.esconderNumeroCartao(pagamento.getCartao());
        pagamento.setCartao(cartaoNovo);
        respostaPagamentoDTO = requisicaoConverter.convertToRequisicaoPagamentoResposta(pagamento);

        return respostaPagamentoDTO;
    }

    @Override
    public RespostaPagamentoDTO realizarEstorno(Long id) {
        Pagamento pagEstorno = this.getPagamento(id);
        if (ObjectUtils.isEmpty(pagEstorno)) {
            return null;
        }
        pagEstorno.setStatus(Status.CANCELADO);
        Pagamento pagamentoEstorno = pagamentoRepositorio.save(pagEstorno);
        String cartaoNovo = this.esconderNumeroCartao(pagamentoEstorno.getCartao());
        pagamentoEstorno.setCartao(cartaoNovo);
        RespostaPagamentoDTO respostaEstornoDTO = requisicaoConverter.convertToRequisicaoPagamentoResposta(pagamentoEstorno);
        return respostaEstornoDTO;
    }

    @Override
    public Pagamento getPagamento(Long idPagamento) {
        Optional<Pagamento> pagamento = pagamentoRepositorio.findById(idPagamento);
        if (ObjectUtils.isEmpty(pagamento)) {
            return null;
        }
        return pagamento.get();
    }

    @Override
    public RespostaPagamentoDTO buscarPagamentoId(Long id) {
        Pagamento pagamento = this.pagamentoRepositorio
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        String cartaoNovo = this.esconderNumeroCartao(pagamento.getCartao());
        pagamento.setCartao(cartaoNovo);
        RespostaPagamentoDTO respostaEstornoDTO = requisicaoConverter.convertToRequisicaoPagamentoResposta(pagamento);

        return respostaEstornoDTO;
    }

    @Override
    public String esconderNumeroCartao(String cartao) {
        if (ObjectUtils.isEmpty(cartao)) {
            return null;
        }
        String cpfNovo = "";
        for (int x = 0; x < cartao.length() - 4; x++) {
            cpfNovo += "*";
        }
        return cpfNovo + cartao.substring(cartao.length() - 4);
    }

    @Override
    public List<RespostaPagamentoDTO> buscarListaPagamento(){
        List<Pagamento> pagamento = pagamentoRepositorio.findAll();

        List<RespostaPagamentoDTO> respostaPagamentoDTOS = new ArrayList<RespostaPagamentoDTO>();
        for (int i = 0; i < pagamento.size(); i++){
            Pagamento pagamentoNovo = pagamento.get(i);
            RespostaPagamentoDTO respostaPagamentoDTO = requisicaoConverter.convertToRequisicaoPagamentoResposta(pagamentoNovo);
            respostaPagamentoDTOS.add(respostaPagamentoDTO);
        }

        return respostaPagamentoDTOS;
    }


}
