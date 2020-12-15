public class FrogCommands {

    public static FrogCommand jumpCommand(final Frog_Pryg_Skok frog, final int step) {

        return new FrogCommand() {

            @Override
            public boolean doCommand() {

                return frog.jump(step);
            }

            @Override
            public boolean undoCommand() {
                return frog.jump(-step);
            }

        };
    }
}