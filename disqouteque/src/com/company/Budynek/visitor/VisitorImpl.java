package com.company.Budynek.visitor;

import com.company.Budynek.Ochroniarze.RejestrObcych;
import com.company.Osoby.CzlowiekZZewnatrz;
import com.company.Osoby.Student;
import com.company.Osoby.Studentka;

public class VisitorImpl implements UczestnikVIsitor {
    private RejestrObcych rejestrObcych;

    public VisitorImpl(RejestrObcych rejestrObcych) {
        this.rejestrObcych = rejestrObcych;
    }

    @Override
    public void visitStudent(Student student) {

    }

    @Override
    public void visitStudentka(Studentka studentka) {

    }

    @Override
    public void visitCzlowiekZZewnatrz(CzlowiekZZewnatrz czlowiekZZewnatrz) {
        if (rejestrObcych.ifExist(czlowiekZZewnatrz.getImie(), czlowiekZZewnatrz)) {
            rejestrObcych.dodawajDoRejestru(czlowiekZZewnatrz);
        }
    }
}
