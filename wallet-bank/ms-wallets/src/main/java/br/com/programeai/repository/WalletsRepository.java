package br.com.programeai.repository;

import br.com.programeai.model.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletsRepository extends JpaRepository <WalletEntity, Long> {

    WalletEntity findByWalletNumber(String number);
}
