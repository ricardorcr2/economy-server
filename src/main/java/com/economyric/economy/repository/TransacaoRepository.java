package com.economyric.economy.repository;

import com.economyric.economy.domain.TipoTransacaoEnum;
import com.economyric.economy.domain.Transacao;
import com.economyric.economy.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
    List<Transacao> findAll();

    List<Transacao> findAllByTipoTransacao(TipoTransacaoEnum tipoTransacao);

    List<Transacao> findAllByTipoTransacaoAndUser(TipoTransacaoEnum tipoTransacao, User user);
}
