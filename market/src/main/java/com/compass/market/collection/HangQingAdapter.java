//package com.compass.market.collection;
//
//import android.content.Context;
//import android.view.ViewGroup;
//import com.compass.common.base.BaseAdapter;
//import com.compass.common.base.BaseViewHolder;
//
//import java.util.List;
//
//
//public class HangQingAdapter extends BaseAdapter {
//
//    public static final int INDEX = 0;
//    public static final int CP2 = 1;
//    public static final int CP3 = 2;
//    public static final int TITLE = 3;
//    public static final int STOCK = 4;
//
//    @Override
//    public int getItemViewType(int position) {
//        Object object = getItem(position);
//        if(object instanceof List ){
//            return INDEX;
//        }
////        else if(object instanceof Cp2Model){
////            return CP2;
////        }else if(object instanceof Cp3Model){
////            return CP3;
////        }else if(object instanceof TitleModel){
////            return TITLE;
////        }else if(object instanceof StockModel){
////            return STOCK;
////        }
//        return 0;
//    }
//
//
//
//    public HangQingAdapter(Context context) {
//        super(context);
//    }
//
//    @Override
//    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
//        switch (viewType) {
//            case INDEX:
//                return new CustomIndexHolder(parent);
////            case CP2:
////                return new Cp2BoradHolder(parent);
////            case CP3:
////                return new Cp3BoradHolder(parent);
////            case TITLE:
////                return new TitleHolder(parent);
////            case STOCK:
////                return new StockHolder(parent);
//            default:
//                return null;
//        }
//    }
//}
