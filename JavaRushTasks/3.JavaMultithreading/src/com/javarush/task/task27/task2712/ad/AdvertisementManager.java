package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private final int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        Collections.sort(storage.list(), new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return -result;

                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        });


        List<Advertisement> adList = storage.list();
        if (adList.isEmpty() || adList == null)
            throw new NoVideoAvailableException();

        int totalDuration = 0;
        long totalAmount = 0;
        List<Advertisement> adsForShow = new ArrayList<>();
        for (Advertisement ad : adList) {
            totalAmount += ad.getAmountPerOneDisplaying();
            totalDuration += ad.getDuration();
            if (totalDuration <= timeSeconds && ad.getDuration() <= timeSeconds) {
                adsForShow.add(ad);
            }
            else {
                totalAmount -= ad.getAmountPerOneDisplaying();
                totalDuration -= ad.getDuration();
            }
        }


        //Register event before showing videos
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(
                adsForShow, totalAmount, totalDuration));

        int timeLeft = timeSeconds;
        for (Advertisement advertisement : storage.list()) {
            if (timeLeft < advertisement.getDuration()) {
                continue;
            }

            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }

        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }
        
    }
}
