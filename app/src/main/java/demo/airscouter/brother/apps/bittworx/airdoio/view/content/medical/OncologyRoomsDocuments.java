package demo.airscouter.brother.apps.bittworx.airdoio.view.content.medical;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import demo.airscouter.brother.apps.bittworx.airdoio.R;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.B;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.C;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.ContextData;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.G;
import demo.airscouter.brother.apps.bittworx.airdoio.helper.TextHelper;
import demo.airscouter.brother.apps.bittworx.airdoio.poco.Document;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.Content;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.ContentArea;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.RunableContent;
import demo.airscouter.brother.apps.bittworx.airdoio.view.content.Site;

/**
 * Created by marcel.weissgerber on 15.02.2017.
 */

public class OncologyRoomsDocuments {


    public static Site getDoc1() {
        Site result = new Site();

        result.add(new ContentArea(1,1,true).add(0, 0, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.room_medical_single,bounds);
            }
        }));
        result.add(new ContentArea(5,10,true).add(0, 4, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                TextHelper.drawText(canvas,"Room 201 Shapes",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }
        }));
        result.add(new ContentArea(1,1).add(0, 0, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.room_medical_single_furniture,bounds);
            }
        }));
        result.add(new ContentArea(1,1).add(0, 0, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.room_medical_single_person_001,bounds);
            }
        }));
        result.add(new ContentArea(5,10).add(4,4, new RunableContent() {
            @Override
            protected void drawContent(Canvas canvas, RectF bounds) {

                TextHelper.drawText(canvas,"Patient: M. Huber - Click on the bed",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }

            @Override
            protected Runnable getAction() {


                return new Runnable() {
                    @Override
                    public void run() {

                            ContextData.document.clearWith(new Document("").setSite(getPersonHuber()));
                        if(ContextData.activity!=null)
                            ContextData.activity.refresh();
                    }
                };
            }


        }));
        return result;
    }
    public static Site getDoc2() {
        Site result = new Site();

        result.add(new ContentArea(1,1,true).add(0, 0, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.room_medical_single,bounds);
            }
        }));
        result.add(new ContentArea(5,10).add(0, 4, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                TextHelper.drawText(canvas,"Room 202 Shapes",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }
        }));
        result.add(new ContentArea(1,1).add(0, 0, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.room_medical_single_furniture,bounds);
            }
        }));
        result.add(new ContentArea(1,1).add(0, 0, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.room_medical_single_person_001,bounds);
            }
        }));
        result.add(new ContentArea(5,10).add(4,4, new RunableContent() {
            @Override
            protected void drawContent(Canvas canvas, RectF bounds) {

                TextHelper.drawText(canvas,"Patient: R. Rabbit - Click on the bed",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }

            @Override
            protected Runnable getAction() {


                return new Runnable() {
                    @Override
                    public void run() {

                        ContextData.document.clearWith(new Document("").setSite(getPersonHuber()));
                        if(ContextData.activity!=null)
                            ContextData.activity.refresh();
                    }
                };
            }


        }));
        return result;
    }
    public static Site getDoc3() {
        Site result = new Site();

        result.add(new ContentArea(1,1,true).add(0, 0, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.room_medical_single,bounds);
            }
        }));
        result.add(new ContentArea(5,10).add(0, 4, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                TextHelper.drawText(canvas,"Room 203 Shapes",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }
        }));
        result.add(new ContentArea(1,1).add(0, 0, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.room_medical_single_furniture,bounds);
            }
        }));
        result.add(new ContentArea(1,1).add(0, 0, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.room_medical_single_person_001,bounds);
            }
        }));
        result.add(new ContentArea(5,10).add(4,4, new RunableContent() {
            @Override
            protected void drawContent(Canvas canvas, RectF bounds) {

                TextHelper.drawText(canvas,"Patient: J. John - Click on the bed",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }

            @Override
            protected Runnable getAction() {


                return new Runnable() {
                    @Override
                    public void run() {

                        ContextData.document.clearWith(new Document("").setSite(getPersonHuber()));
                        if(ContextData.activity!=null)
                            ContextData.activity.refresh();
                    }
                };
            }


        }));
        return result;
    }

    public static Site getPersonHuber(){
        Site result = new Site();
        result.add(new ContentArea(6,12,true).add(1,1, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {
                B.drawBitmap(canvas, R.drawable.pf,bounds);


            }
        }));
        result.add(new ContentArea(6,10,true).add(0, 2, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {


                TextHelper.drawTextLeft(canvas,"Patient: ",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }
        }));
        result.add(new ContentArea(6,10,true).add(1, 2, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {


                TextHelper.drawTextLeft(canvas,"Age: ",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }
        }));
        result.add(new ContentArea(6,10,true).add(0, 4, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {


                TextHelper.drawTextLeft(canvas,"M. Huber",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }
        }));
        result.add(new ContentArea(6,10,true).add(1, 4, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {


                TextHelper.drawTextLeft(canvas,"46",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }
        }));
        result.add(new ContentArea(6,10).add(2, 2, new Content() {
            @Override
            protected void draw(Canvas canvas, RectF bounds) {


                TextHelper.drawTextLeft(canvas,"Diagnose: ",bounds,1,TextHelper.getFont(bounds,Color.WHITE));
            }
        }));
        return result;
    }

}
