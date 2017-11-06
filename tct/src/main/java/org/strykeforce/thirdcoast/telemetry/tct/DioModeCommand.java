package org.strykeforce.thirdcoast.telemetry.tct;

import javax.inject.Inject;
import javax.inject.Provider;
import org.jline.reader.LineReader;
import org.strykeforce.thirdcoast.telemetry.tct.dio.DioMenuComponent;

/**
 * Command to enter mode for working with Dios.
 */
public class DioModeCommand extends AbstractCommand {

  public final static String NAME = "Work with DIOs";
  private final Provider<DioMenuComponent.Builder> dioMenuComponentProvider;

  @Inject
  public DioModeCommand(Provider<DioMenuComponent.Builder> dioMenuComponentProvider,
      LineReader reader) {
    super(NAME, reader);
    this.dioMenuComponentProvider = dioMenuComponentProvider;
  }

  @Override
  public void perform() {
    DioMenuComponent component = dioMenuComponentProvider.get().build();
    Menu menu = component.menu();
    menu.display();
  }
}