package com.odigeo.rover.service.command;

import com.odigeo.rover.model.Rover;

import javax.inject.Singleton;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Singleton
public class CommandProcessor {

    public void processCommand(String commands, Rover rover) {
        if (commands == null || commands.isEmpty()) {
            throw new IllegalArgumentException("Commands cannot be null or empty");
        } else if (areCommandsValid(commands)) {
            executeCommand(commands, rover);
        } else {
            throw new IllegalArgumentException("Invalid command format: " + commands);
        }
    }

    private void executeCommand(String commands, Rover rover) {
        Pattern pattern = Pattern.compile("(\\d+)([LRM])");
        Matcher matcher = pattern.matcher(commands);

        while (matcher.find()) {
            int repetition = Integer.parseInt(matcher.group(1));
            char command = matcher.group(2).charAt(0);

            for (int i = 0; i < repetition; i++) {
                processSimpleCommand(command, rover);
            }
        }
    }

    private boolean areCommandsValid(String commands) throws IllegalArgumentException {
        final String regexMatch = "(\\d+[LRM])+";
        if (!commands.matches(regexMatch)) {
            return false;
        }
        return true;
    }

    private void processSimpleCommand(char command, Rover rover) {
        switch (command) {
            case 'L':
                rover.rotateDirectionLeft();
                break;
            case 'R':
                rover.rotateDirectionRight();
                break;
            case 'M':
                rover.moveForward();
                break;
            default:
                throw new IllegalArgumentException("Invalid command: " + command);
        }
    }

}
