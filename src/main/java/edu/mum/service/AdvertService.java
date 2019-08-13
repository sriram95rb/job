package edu.mum.service;


import edu.mum.domain.Advert;

import java.util.List;

public interface AdvertService {

    public Advert saveAdvert(Advert advert);

    public List<Advert> getAdverts();

    public Advert getAdvertById(Long id);

}