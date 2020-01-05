package eu.faircode.email;

/*
    This file is part of FairEmail.

    FairEmail is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    FairEmail is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with FairEmail.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2018-2020 by Marcel Bokhorst (M66B)
*/

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.QuoteSpan;

import androidx.annotation.NonNull;

public class StyledQuoteSpan extends QuoteSpan {
    private int stripeWidth;
    private int gapWidth;

    StyledQuoteSpan(Context context, int color) {
        super(color);
        stripeWidth = Helper.dp2pixels(context, 3);
        gapWidth = Helper.dp2pixels(context, 6);
    }

    @Override
    public int getLeadingMargin(boolean first) {
        return stripeWidth + gapWidth;
    }

    @Override
    public void drawLeadingMargin(
            @NonNull Canvas c, @NonNull Paint p,
            int x, int dir, int top, int baseline, int bottom,
            @NonNull CharSequence text, int start, int end, boolean first,
            @NonNull Layout layout) {
        Paint.Style style = p.getStyle();
        int color = p.getColor();

        p.setStyle(Paint.Style.FILL);
        p.setColor(getColor());

        c.drawRect(x, top, x + dir * stripeWidth, bottom, p);

        p.setStyle(style);
        p.setColor(color);
    }
}
