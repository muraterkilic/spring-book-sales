package com.example.book.seller.service;

import com.example.book.seller.model.PurchaseHistory;
import com.example.book.seller.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseHistoryService
{

    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseItem> findPurchasedItemOfUser(Long userId);
}
