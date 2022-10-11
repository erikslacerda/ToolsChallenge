package com.tools.crm.dto;

import com.tools.crm.model.Status;
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
public class DescTransacaoRepostaDTO {
    @NotNull
    private Double valor;
    @NotNull
    private LocalDate dataHora;
    @NotEmpty
    private String estabelecimento;
    @NotNull
    private Integer nsu;
    @NotNull
    private Integer condigoAutorizacao;
    @NotNull
    private Status status;

    @Override
    public String toString() {
        return "descricaoRespostaDTO [valor=" + valor + ", dataHora=" + dataHora +
                ", estabelecimento=" + estabelecimento + ", nsu" + nsu +
                ", condigoAutorizacao" + condigoAutorizacao +
                ", status" + status + "]";
    }
}
