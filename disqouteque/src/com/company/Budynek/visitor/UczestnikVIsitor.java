package com.company.Budynek.visitor;

import com.company.Osoby.CzlowiekZZewnatrz;
import com.company.Osoby.Student;
import com.company.Osoby.Studentka;

public interface UczestnikVIsitor {
    void visitStudent(Student student);
    void visitStudentka(Studentka studentka);
    void visitCzlowiekZZewnatrz(CzlowiekZZewnatrz czlowiekZZewnatrz);
}
