package com.bahcesehir.autobahn.services;


import com.bahcesehir.autobahn.controllers.dto.FinalStorageCreateDto;
import com.bahcesehir.autobahn.controllers.views.FinalStorageTypeView;
import com.bahcesehir.autobahn.controllers.views.FinalStorageView;
import com.sun.istack.internal.FinalArrayList;

public interface FinalStorageService {

    FinalStorageView createFinalStorage(FinalStorageCreateDto dto);

    Iterable<FinalStorageView> getFinalStorageByProject(Long projectId);

    Iterable<FinalStorageTypeView> getFinalStorageTypes();

}
