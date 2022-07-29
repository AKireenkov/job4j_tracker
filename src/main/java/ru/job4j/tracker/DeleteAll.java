package ru.job4j.tracker;

public class DeleteAll implements UserAction {
    private final Output out;

    public DeleteAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ===");
       for (int i = 0; i <= 10000; i++) {
           tracker.delete(i);
       }
        return true;
    }
}
