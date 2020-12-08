package ceva.command;

import cqrs.Command;

import java.util.UUID;

public class EliminaPersoana implements Command {
    public final UUID id = UUID.randomUUID();
}
