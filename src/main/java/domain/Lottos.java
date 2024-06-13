package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos{
    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }


    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto ::toString)
                .collect(Collectors.joining(", "));
    }



}
