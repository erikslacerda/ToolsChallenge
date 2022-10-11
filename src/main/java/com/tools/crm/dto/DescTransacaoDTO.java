package com.tools.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DescTransacaoDTO {
    @NotNull
    private Double valor;
    @NotNull
    private LocalDate dataHora;
    @NotEmpty
    private String estabelecimento;

    @Override
    public String toString() {
        return "descricaoDTO [valor=" + valor + ", dataHora=" + dataHora + ", estabelecimento=" + estabelecimento + "]";
    }
}
