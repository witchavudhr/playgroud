//package com.playground.playground.contributor;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.actuate.info.Info;
//import org.springframework.boot.actuate.info.InfoContributor;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class VersionInfoContributor implements InfoContributor {
//
//    @Value("${git.commit.message.short}")
//    private String commitMessage;
//
//    @Value("${git.branch}")
//    private String branch;
//
//    @Value("${git.commit.id}")
//    private String commitId;
//
//    @Value("${git.build.time}")
//    private String buildTime;
//
//    @Value("${git.commit.user.name}")
//    private String commitName;
//
//    public void contribute(Info.Builder builder) {
//        Map<String, String> gitInfo = new HashMap<>();
//        gitInfo.put("Commit message",commitMessage);
//        gitInfo.put("Commit branch", branch);
//        gitInfo.put("Commit id", commitId);
//        gitInfo.put("Build time", buildTime);
//        gitInfo.put("Commit name", commitName);
//
//        builder.withDetail("git", gitInfo);
//    }
//}
