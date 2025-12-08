package com.example.MiniLoanAndEMICalculator_Backend.MiniLoan.service;

import com.example.MiniLoanAndEMICalculator_Backend.MiniLoan.dto.LoanRequest;
import com.example.MiniLoanAndEMICalculator_Backend.MiniLoan.entity.Loan;
import com.example.MiniLoanAndEMICalculator_Backend.MiniLoan.repository.LoanRepository;
import org.springframework.stereotype.Service;



@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan applyLoan(LoanRequest request) {

        Loan loan = new Loan();
        loan.setUserId(request.getUserId());
        loan.setAmount(request.getAmount());
        loan.setTenure(request.getTenure());
        loan.setInterestRate(request.getInterestRate());

        // EMI Formula
        double r = request.getInterestRate() / (12 * 100);
        int n = request.getTenure();

        double emi = (request.getAmount() * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        loan.setEmi(emi);

        return loanRepository.save(loan);
    }
}
