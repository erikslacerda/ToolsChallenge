package com.tools.crm.dto;

import com.tools.crm.model.FormaPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamentoDTO {

    @NotNull
    private FormaPagamento tipo;
    @NotNull
    private Long parcelas;

    @Override
    public String toString() {
        return "formaDTO [tipo=" + tipo + ", parcelas" + parcelas + "]";
    }
}
