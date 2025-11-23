package br.com.safeline.modules.user.repository;

import br.com.safeline.modules.user.model.AccessToken;
import br.com.safeline.modules.user.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessToken, UUID> {

    Optional<AccessToken> findByToken(String token);

    Optional<AccessToken> findFirstByRefreshTokenOrderByCreatedAtDesc(RefreshToken refreshToken);
}
