package com.tools.crm.service.impl;

import com.tools.crm.dto.RequisicaoPagamentoDTO;
import com.tools.crm.dto.TransacaoDTO;
import com.tools.crm.model.FormaPagamento;
import com.tools.crm.model.Pagamento;
import com.tools.crm.model.Status;
import com.tools.crm.repository.PagamentoRepository;
import com.tools.crm.service.PagamentoServico;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TransacaoServiceImplTest {

    @Autowired
    private PagamentoServico pagamentoservico;

    @Autowired
    private PagamentoRepository pagamentoRepositorio;

    @Test
    public void validarPagamento(){
        Pagamento pagamento = new Pagamento();
                pagamento.setCartao("12121212121212");
                pagamento.setValor(22.22);
                pagamento.setDateTime( LocalDate.now().plusYears(3));
                pagamento.setEstabelecimento("Pet");
                pagamento.setTipo(FormaPagamento.AVISTA);
                pagamento.setParcelas(1L);
                pagamento.setNsu(1234);
                pagamento.setStatus(Status.AUTORIZADO);
                pagamento.setCondigoAutorizacao(1111111);
        pagamentoRepositorio.save(pagamento);
        Assert.assertNotNull(pagamento.getId());
    }

    @Test
    public void esconderCartaoComSucesso() {
        String cpfAntigo = "12345671233";
        String cpfNovo = pagamentoservico.esconderNumeroCartao(cpfAntigo);
        Assert.assertEquals("*******1233", cpfNovo);
    }
}
