package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new ArrayList<>(List.of("1515", "0")));
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(
                Collections.singleton(new ExitActions(out))
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu." + ln
                                + "0. Exit Program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu." + ln
                                + "0. Exit Program" + ln
                                + "=== Exit Program ===" + ln
                )
        );
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new ArrayList<>(List.of("0"))
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(new ExitActions(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new ArrayList<>(List.of("0", "Item name", "1")
                ));
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions =
                (List.of(new CreateAction(out),
                        new ExitActions(out)));
        new StartUI(new StubOutput()).init(in, memTracker, actions);
        Assert.assertTrue(memTracker.findByName("Item name")
                .stream()
                .anyMatch(el -> el.getName().equals("Item name")));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new ArrayList<>(List.of("0", String.valueOf(item.getId()), replacedName, "1"))
        );
        List<UserAction> actions =
                (List.of(new EditAction(out),
                        new ExitActions(out)));
        new StartUI(new StubOutput()).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new ArrayList<>(List.of("0", String.valueOf(item.getId()), "1"))
        );
        List<UserAction> actions = (List.of(
                new DeleteActions(out),
                new ExitActions(out)
        ));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new ArrayList<>(List.of("0", String.valueOf(one.getId()), replaceName, "1"))
        );
        List<UserAction> actions = new ArrayList<>(List.of(
                new EditAction(out),
                new ExitActions(out)
        ));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindAllItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Item two = memTracker.add(new Item("test2"));
        Input in = new StubInput(
                new ArrayList<>(List.of("0", "1"))
        );
        List<UserAction> actions = new ArrayList<>(List.of(new ShowAllActions(out),
                new ExitActions(out)));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + two + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new ArrayList<>(List.of("0", one.getName(), "1"))
        );
        List<UserAction> actions = new ArrayList<>(List.of(new FindByNameActions(out),
                new ExitActions(out)));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new ArrayList<>(Arrays.asList("0", String.valueOf(one.getId()), "1"))
        );
        List<UserAction> actions = new ArrayList<>(List.of(new FindByIdActions(out),
                new ExitActions(out)));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenEditWithMockito() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Заявка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteWithMockito() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Delete item"));
        DeleteActions del = new DeleteActions(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenFindByIdWithMockito() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("FindById item");
        tracker.add(item);
        FindByIdActions find = new FindByIdActions(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + item + ln));
        assertThat(tracker.findById(1), is(item));
    }

    @Test
    public void whenFindByNameWithMockito() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("FindByName item");
        tracker.add(item);
        FindByNameActions find = new FindByNameActions(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        find.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + item + ln));
        assertThat(tracker.findById(1), is(item));
    }
}