package com.tools.crm.model;

import lombok.*;

import java.time.LocalDate;
import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "pagamento")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cartao;
	private Double valor;
	private LocalDate dateTime;
	private String estabelecimento;
	private Integer nsu;
	private Integer condigoAutorizacao;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Enumerated(EnumType.STRING)
	private FormaPagamento tipo;
	private Long parcelas;

	public Pagamento(String cartao, Double valor, LocalDate dateTime,
					 String estabelecimento, Integer nsu, Integer condigoAutorizacao, Status status,FormaPagamento tipo, Long parcelas){
		super();
//		this.idPagamento = idPagamento;
		this.cartao = cartao;
		this.valor = valor;
		this.dateTime = dateTime;
		this.estabelecimento = estabelecimento;
		this.nsu = nsu;
		this.condigoAutorizacao = condigoAutorizacao;
		this.status = status;
		this.tipo = tipo;
		this.parcelas = parcelas;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", cartao=" + cartao + ", valor=" + valor
				+ ", estabelecimento=" + estabelecimento + ", nsu=" + nsu + ", condigoAutorizacao=" + condigoAutorizacao + ", status=" + status
				+ ", tipo=" + tipo + ", parcelas=" + parcelas + "]";
	}
}
