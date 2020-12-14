package com.rando.service;

import java.util.List;

import com.rando.modele.Photo;

public interface PhotoService {
	List<Photo> getAllPhotosByIdEtape(int idEtape);
	
	public void savePhotosWithEtape(String urlPhoto ,int idEtape);
}
