package com.tools.crm.service;

import com.tools.crm.dto.RequisicaoPagamentoDTO;
import com.tools.crm.dto.RespostaPagamentoDTO;
import com.tools.crm.model.Pagamento;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PagamentoServico {

    RespostaPagamentoDTO realizarPagamento(RequisicaoPagamentoDTO requisicaoPagamentoDTO);

    RespostaPagamentoDTO realizarEstorno(Long id);

    Pagamento getPagamento(Long id);

    RespostaPagamentoDTO buscarPagamentoId(Long id);

    String esconderNumeroCartao(String cartao);

    List<RespostaPagamentoDTO> buscarListaPagamento();
}
