package com.tools.crm.convert;

import com.tools.crm.dto.*;
import com.tools.crm.model.Pagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequisicaoConverter {
    public Pagamento convertToRequisicaoPagamento(RequisicaoPagamentoDTO requisicaoPagamentoDTO) {
        return Pagamento.builder()
                .cartao(requisicaoPagamentoDTO.getTransacao().getCartao())
                .valor(requisicaoPagamentoDTO.getTransacao().getDescricao().getValor())
                .dateTime(requisicaoPagamentoDTO.getTransacao().getDescricao().getDataHora())
                .estabelecimento(requisicaoPagamentoDTO.getTransacao().getDescricao().getEstabelecimento())
                .tipo(requisicaoPagamentoDTO.getTransacao().getFormaPagamento().getTipo())
                .parcelas(requisicaoPagamentoDTO.getTransacao().getFormaPagamento().getParcelas())
                .build();

    }

    public RespostaPagamentoDTO convertToRequisicaoPagamentoResposta(Pagamento pagamento) {
        FormaPagamentoDTO formaPagamentoDTO = FormaPagamentoDTO.builder()
                .tipo(pagamento.getTipo())
                .parcelas(pagamento.getParcelas())
                .build();
        DescTransacaoRepostaDTO descTransacaoRepostaDTO = DescTransacaoRepostaDTO.builder()
                .valor(pagamento.getValor())
                .dataHora(pagamento.getDateTime())
                .estabelecimento(pagamento.getEstabelecimento())
                .nsu(pagamento.getNsu())
                .condigoAutorizacao(pagamento.getCondigoAutorizacao())
                .status(pagamento.getStatus())
                .build();
        TransacaoRespostaDTO transacaoRespostaDTOrespostaDTO = TransacaoRespostaDTO.builder()
                .id(pagamento.getId())
                .cartao(pagamento.getCartao())
                .descricao(descTransacaoRepostaDTO)
                .formaPagamento(formaPagamentoDTO)
                .build();
        return RespostaPagamentoDTO.builder()
                .transacaoRespostaDTO(transacaoRespostaDTOrespostaDTO)
                .build();
    }
}
