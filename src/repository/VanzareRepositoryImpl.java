package repository;

import model.Vanzare;

import java.util.ArrayList;
import java.util.List;

public class VanzareRepositoryImpl implements VanzareRepository {
    private List<Vanzare> vanzareList = new ArrayList<>();

    @Override
    public List<Vanzare> findAll() {
        return new ArrayList<>(vanzareList);
    }

    @Override
    public void save(Vanzare vanzare) {
        vanzareList.add(vanzare);
    }

    @Override
    public void delete(Vanzare vanzare) {
        vanzareList.removeIf(v -> v.getId() == vanzare.getId());
    }
}