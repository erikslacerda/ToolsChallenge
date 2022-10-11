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
public class RespostaEstornoDTO {

    @NotNull
    private TransacaoEstornoDTO transacaoEstorno;

    public @NotNull TransacaoEstornoDTO getTransacaoEstornoDTO() {
        return transacaoEstorno;
    }

    public void setTransacaoEstornoDTO(TransacaoEstornoDTO transacaoEstorno) {
        this.transacaoEstorno = transacaoEstorno;
    }
}
