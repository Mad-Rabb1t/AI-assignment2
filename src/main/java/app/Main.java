package app;

import app.entity.Data;
import io.Input;

import java.io.FileNotFoundException;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    String filename = "data1.txt";
    Data data = Input.getData(filename);
    Backtracking backtracking = new Backtracking();
    backtracking.graphColoring(data.getGraph(), data.getColors());
  }
}
