package org.wahlzeit.model;

import java.util.logging.Logger;

public class BikePhotoManager extends PhotoManager {

    protected static final BikePhotoManager instance = new BikePhotoManager();

    private static final Logger log = Logger.getLogger(BikePhotoManager.class.getName());

    public BikePhotoManager() {
        photoTagCollector = BikePhotoFactory.getInstance().createPhotoTagCollector();
    }

    public static final BikePhotoManager getInstance() {
        return instance;
    }

 
    public BikePhoto getPhotoFromId(PhotoId id) {
        if (id == null) {
            return null;
        }

        BikePhoto result = (BikePhoto) super.doGetPhotoFromId(id);

        if (result == null) {
            result = BikePhotoFactory.getInstance().loadPhoto(id);
            if (result != null) {
                super.doAddPhoto(result);
            }
        }

        return result;
    }

    protected BikePhoto doGetPhotoFromId(PhotoId id) {
        return (BikePhoto) photoCache.get(id);
    }

    protected void doAddPhoto(BikePhoto myPhoto) {
        photoCache.put(myPhoto.getId(), myPhoto);
    }
}
