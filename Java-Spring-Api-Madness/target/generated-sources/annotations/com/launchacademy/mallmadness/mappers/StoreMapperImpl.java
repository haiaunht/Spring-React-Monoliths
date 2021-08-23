package com.launchacademy.mallmadness.mappers;

import com.launchacademy.mallmadness.dtos.StoreDto;
import com.launchacademy.mallmadness.models.Store;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-16T08:06:42-0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class StoreMapperImpl implements StoreMapper {

    @Override
    public StoreDto storeToStoreDto(Store store) {
        if ( store == null ) {
            return null;
        }

        StoreDto storeDto = new StoreDto();

        if ( store.getAverageCost() != null ) {
            storeDto.setAverageCostToString( String.valueOf( store.getAverageCost() ) );
        }
        storeDto.setName( store.getName() );
        storeDto.setType( store.getType() );
        storeDto.setOperatingStatus( store.getOperatingStatus() );

        return storeDto;
    }

    @Override
    public List<StoreDto> storesToStoreDtos(List<Store> stores) {
        if ( stores == null ) {
            return null;
        }

        List<StoreDto> list = new ArrayList<StoreDto>( stores.size() );
        for ( Store store : stores ) {
            list.add( storeToStoreDto( store ) );
        }

        return list;
    }
}
