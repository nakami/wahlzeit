package org.wahlzeit.model;

import org.wahlzeit.annotations.PatternInstance;
import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

// https://en.wikipedia.org/wiki/Abstract_factory_pattern
@PatternInstance(
    patternName = "Abstract Factory",
    participants = {
        "Factory"
    }
)

// https://en.wikipedia.org/wiki/Singleton_pattern
@PatternInstance(
    patternName = "Singleton",
    participants = {
        "Singleton"
    }
)

public class BikePhotoFactory extends PhotoFactory{

    private static final Logger log = Logger.getLogger(BikePhotoFactory.class.getName());

    private static BikePhotoFactory instance = null;

    protected BikePhotoFactory() {
        // do nothing
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    public static synchronized BikePhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new BikePhotoFactory());
        }
        return instance;
    }

    protected static synchronized void setInstance(BikePhotoFactory bikePhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize BikePhotoFactory twice");
        }

        instance = bikePhotoFactory;
    }


    public BikePhoto createPhoto() {
        return new BikePhoto();
    }

    public BikePhoto createPhoto(PhotoId id) {
        return new BikePhoto(id);
    }

    public BikePhoto loadPhoto(PhotoId id) {
       /* Photo result =
                OfyService.ofy().load().type(Photo.class).ancestor(KeyFactory.createKey("Application", "Wahlzeit")).filter(Photo.ID, id).first().now();
        for (PhotoSize size : PhotoSize.values()) {
            GcsFilename gcsFilename = new GcsFilename("picturebucket", filename);



        }*/
        return null;
    }
}
