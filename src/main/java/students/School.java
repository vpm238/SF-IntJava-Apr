package students;

import java.util.ArrayList;
import java.util.List;

public final class School {

  public static void showAll(List<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("========================================");
  }
// BAD!!! Mixes selection of smart students with what to do with them!
//  public static void showAllSmart(List<Student> ls) {
//    for (Student s : ls) {
//      if (s.getGpa() > 3) {
//        System.out.println("> " + s);
//      }
//    }
//    System.out.println("========================================");
//  }

  public static List<Student> getSmart(Iterable<Student> ls, float threshold) {
    List<Student> result = new ArrayList<>();
    for (Student s : ls) {
      if (s.getGpa() > threshold) {
        result.add(s);
      }
    }
    return result;
  }

//  public static List<Student> getFairlySmart(Iterable<Student> ls) {
//    List<Student> result = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.getGpa() > 2.6) {
//        result.add(s);
//      }
//    }
//    return result;
//  }
//
  public static void main(String[] args) {
    List<Student> school = List.of(
        Student.ofNameGpaCourses("Fred", 2.7F, "Math", "Physics"),
        Student.ofNameGpaCourses("Jim", 2.2F, "Math"),
        Student.ofNameGpaCourses("Sheila", 3.8F, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    showAll(school);
    showAll(getSmart(school, 3.0F));
//    showAll(getFairlySmart(school));
    showAll(getSmart(school, 2.6F));
  }
}