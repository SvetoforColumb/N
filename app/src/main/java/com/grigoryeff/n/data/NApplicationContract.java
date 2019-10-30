package com.grigoryeff.n.data;

import android.provider.BaseColumns;

public class NApplicationContract {
    private NApplicationContract() {
    };

    public static final class Exams implements BaseColumns {
        public final static String TABLE_NAME = "exams";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_CREATION_DATE = "creation_date";
    }


    public static final class Questions implements BaseColumns {
        public final static String TABLE_NAME = "questions";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_NUMBER = "number";
        public final static String COLUMN_TEXT = "text";
        public final static String COLUMN_EXAM_ID = "exam_id";

    }
}
