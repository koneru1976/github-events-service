package com.rkoneru.githubeventsservice.integration;

public class GithubRepositoryEventActor {
    private final Long id;
    private final String login;
    private final String displayLogin;
    private final String gravatarId;
    private final String url;
    private final String avatarUrl;

    public GithubRepositoryEventActor(Long id, String login, String displayLogin, String gravatarId, String url, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.displayLogin = displayLogin;
        this.gravatarId = gravatarId;
        this.url = url;
        this.avatarUrl = avatarUrl;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplayLogin() {
        return displayLogin;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
