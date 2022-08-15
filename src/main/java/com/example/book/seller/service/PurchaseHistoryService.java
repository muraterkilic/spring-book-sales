package com.example.book.seller.service;

import com.example.book.seller.model.PurchaseHistory;
import com.example.book.seller.repository.IPurchaseHistoryRepository;
import com.example.book.seller.repository.projection.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService
{
    @Autowired
    private IPurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory)
    {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());

        return  purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<IPurchaseItem> findPurchasedItemOfUser(Long userId)
    {
        return purchaseHistoryRepository.findAllPurchaseOfUser(userId);
    }
}
