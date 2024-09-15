import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FarmController {
    private FarmView view;
    private ArrayList<CowModel> cows;

    public FarmController(FarmView view, ArrayList<CowModel> cows) {
        this.view = view;
        this.cows = cows;

        view.addSubmitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmission();
            }
        });

        view.addKickGoatListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleKickGoat();
            }
        });

        view.addMilkedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleMilkCow();
            }
        });
    }

    private void handleSubmission() {
        String inputId = view.getInput();

        if (inputId == null || inputId.isEmpty()) {
            view.setDisplayText("Please enter an ID.");
            return;
        }

        for (CowModel cow : cows) {
            if (cow.getId().equals(inputId)) {
                if (cow.getAgeYears() == 0 && cow.getAgeMonths() == 0 && cow.getNumTeats() == 0) {
                    // view.setDisplayText("Cow"+cow.getId()+"It's a Goat!");
                    view.showGoatView();
                    return;
                } else if (cow.getNumTeats() == 3) {
                    view.showCowViewWith3Teats();
                    cow.regainTeatChance();
                    return;
                } else if (cow.getNumTeats() == 4) {
                    view.showCowViewWith4Teats();
                    return;
                }
            }
        }

        view.setDisplayText("No animal found with ID: " + inputId);
    }

    private void handleKickGoat() {
        view.setDisplayText("Goat kicked out!\n"+"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⢠⡿⢶⡀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⢶⣄⡀⢀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⣠⠶⢦⣤⣴⠷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡟⠉⢸⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⠃⠀⠈⠛⠻⣷⣦⡀⠀⠀\r\n" + //
                        "⠀⠀⠀⢀⣀⡴⠞⠁⠀⣆⣵⣀⠀⠈⢷⣄⠀⠀⠀⢀⣀⣴⣾⢋⣼⠇⣾⣿⣿⣦⣀⠀⣀⣠⣤⠤⠖⠒⠲⠦⣤⣤⣀⣀⡀⡀⠀⣀⣠⡤⠖⠛⢀⣠⣤⣿⣶⣶⣿⡿⠟⢶⣄\r\n" + //
                        "⠀⢀⠀⠉⠀⠀⠀⠀⣿⠿⠟⠻⣶⣶⣤⡙⣳⣶⡾⣛⡽⢋⣱⣿⣿⠀⣻⠌⢻⣿⣿⣍⢁⣤⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⢀⣠⣾⣿⡿⠛⠛⠉⠉⠁⠀⠀⠀⠀\r\n" + //
                        "⠀⢼⣮⣼⣆⡀⣤⣀⣿⣶⠆⢀⣀⣿⠿⠟⠋⠁⠾⠋⣴⣾⡿⢿⣿⠀⣻⡆⠘⣿⣿⣿⣿⣿⣿⡟⠉⣀⣼⣶⣤⣀⣀⣄⡀⠀⠰⠶⠾⠛⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠋⠉⠉⠉⠙⠿⠧⠉⣤⣏⡉⠁⠀⠀⢠⡴⢋⣼⣾⡟⠻⠇⣸⠃⠀⣿⣯⠀⠙⢛⣿⣿⣿⣿⣦⣠⣿⣿⣿⠟⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠛⠛⠀⢠⡾⠛⣠⣾⣿⣿⣧⡄⢰⡇⠀⢀⣿⣿⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣡⣾⣿⣿⡿⠋⠉⣱⠟⠁⢀⣼⣿⣯⣼⣿⣿⡿⠀⢙⣿⣿⣿⣿⣿⣿⣶⣤⣤⣀⣀⣤⠴⠶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⣳⡿⠿⠋⠁⢀⠀⢰⡇⠀⢀⣿⢿⣿⠈⢩⠉⠀⠁⠀⠘⢿⣿⣿⣿⠛⢳⣆⣈⣀⠀⠁⠀⣠⣶⣎⠙⠷⣤⣀⣀⣠⡤⣤⣄⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⢀⣤⣴⣤⠶⠟⠁⠉⠀⠀⠀⢀⣾⣇⣼⠃⠀⣼⣿⣿⣹⣾⢸⣦⡀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⣸⣿⣿⣿⣷⣦⣀⠀⠀⠀⢀⣾⣿⣷⣄⣀⣀⣠\r\n" + //
                        "⠀⠀⠀⠀⠀⣠⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⢰⡿⣿⣿⡏⠀⢰⣿⣿⣿⢻⣏⠘⣿⣿⣦⠀⠀⠀⠈⠻⣿⣿⣿⣿⡿⢿⣿⡇⢹⡿⠿⠛⠛⠿⠿⠀⠠⣾⣿⣿⣿⠟⠋⠉⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠚⠿⣿⣿⣿⣦⣤⣶⠶⢶⣷⣶⣟⠀⠹⣿⠁⠀⠀⣿⣿⣿⣿⣿⠠⡿⣿⣿⣷⣄⢀⣄⠀⠈⢿⣧⣤⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠛⠿⣿\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠓⠒⠒⠒⢲⠺⠦⠀⢹⡆⠀⢠⣿⣿⣿⣿⡍⠀⠀⠀⠀⠉⠙⣿⣿⣆⠀⠘⠿⣿⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣷⡇⠀⠀⠀⢸⡇⠀⠸⣿⣿⣿⠉⠀⠀⠀⠀⠀⠀⠀⠙⢹⣿⣷⣦⠀⠈⠻⢷⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠿⠧⠤⠀⣤⡟⠀⣼⣿⣿⢯⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠋⠿⠆⠀⠀⠈⠙⡛⠋⠛⠛⢻⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣷⡄⢿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⣿⡇⠀⢀⣠⣿⣟⢛⣳⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠙⠃⠈⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⢫⣿⡟⠀⣤⣾⣯⣥⣿⡿⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀");
        view.clearInput();
    }

    private void handleMilkCow() {
        String inputId = view.getInput();
        for (CowModel cow : cows) {
            if (cow.getId().equals(inputId)) {
                cow.reduceTeatChance();
                int milkProduced = cow.calculateMilk();
                view.setDisplayText("Cow " + cow.getId() + " produced " + milkProduced + " liters of milk.\n");
                view.clearInput();
                return;
            }
        }
        view.setDisplayText("No cow found with ID: " + inputId);
    }
}
