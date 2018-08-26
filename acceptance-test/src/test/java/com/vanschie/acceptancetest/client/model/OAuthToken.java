package com.vanschie.acceptancetest.client.model;

public class OAuthToken {

    private final String accessType;
    private final String tokenType;
    private final String refreshToken;
    private final String scope;
    private final int expiresIn;

    public OAuthToken(String accessType, String tokenType, String refreshToken, String scope, int expiresIn) {
        this.accessType = accessType;
        this.tokenType = tokenType;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.expiresIn = expiresIn;
    }

    public String getAccessType() {
        return accessType;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OAuthToken{");
        sb.append("accessType='").append(accessType).append('\'');
        sb.append(", tokenType='").append(tokenType).append('\'');
        sb.append(", refreshToken='").append(refreshToken).append('\'');
        sb.append(", scope='").append(scope).append('\'');
        sb.append(", expiresIn=").append(expiresIn);
        sb.append('}');
        return sb.toString();
    }
}
