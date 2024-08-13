package com.demo.plugin;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestSourceRead;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScenarioTracker implements ConcurrentEventListener {

    @Getter
    private static ScenarioTracker instance;

    private List<String> allLastScenarios = Collections.synchronizedList(new ArrayList<>());

    public ScenarioTracker() {
        instance = this;
    }

    @Override
    public synchronized void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestSourceRead.class, this::handleTestSourceRead);
    }

    private synchronized void handleTestSourceRead(TestSourceRead event) {
        String regex = "^\\s*Scenario:.*$";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(event.getSource());

        String lastScenarioLine = null;
        while (matcher.find()) {
            lastScenarioLine = matcher.group().replace("Scenario:", "").trim();
        }

        if (lastScenarioLine != null) {
            this.allLastScenarios.add(lastScenarioLine);
        }
    }

    public synchronized List<String> getAllLastScenarioName() {
        return this.allLastScenarios;
    }
}
