package br.com.safeline.modules.user.model;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_token")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idToken;

    @Column(columnDefinition = "TEXT")
    private String token;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private Instant createdAt;


    private Instant expiresAt;

    @Builder.Default
    private boolean isRevoked = false;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private RefreshToken refreshToken;

}
