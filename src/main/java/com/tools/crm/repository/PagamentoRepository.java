package com.tools.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tools.crm.model.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
