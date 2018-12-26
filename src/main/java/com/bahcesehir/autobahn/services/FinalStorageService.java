package com.bahcesehir.autobahn.services;


import com.bahcesehir.autobahn.controllers.views.FinalStorageTypeView;

public interface FinalStorageService {

    Iterable<FinalStorageTypeView> getFinalStorageTypes();

}
