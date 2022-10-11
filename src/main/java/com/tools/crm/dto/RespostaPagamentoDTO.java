package com.tools.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespostaPagamentoDTO {

    @NotNull
    private TransacaoRespostaDTO transacaoRespostaDTO;

    public @NotNull TransacaoRespostaDTO getTransacaoRespostaDTO() {
        return transacaoRespostaDTO;
    }

    public void setTransacaoRespostaDTO(TransacaoRespostaDTO transacaoResposta) {
        this.transacaoRespostaDTO = transacaoRespostaDTO;
    }
}
