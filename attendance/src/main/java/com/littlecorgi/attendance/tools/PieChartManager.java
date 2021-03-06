package com.littlecorgi.attendance.tools;

import android.graphics.Color;
import android.graphics.Typeface;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import java.util.List;

/**
 * 饼状图
 */
public class PieChartManager {

    public PieChart pieChart;

    public PieChartManager(PieChart pieChart) {
        this.pieChart = pieChart;
        initPieChart();
    }

    private void initPieChart() {
        //  是否显示中间的洞
        //  是否显示中间的洞
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleRadius(40f); // 设置中间洞的大小
        // 半透明圈
        pieChart.setTransparentCircleRadius(30f);
        pieChart.setTransparentCircleColor(Color.WHITE); // 设置半透明圆圈的颜色
        pieChart.setTransparentCircleAlpha(125); // 设置半透明圆圈的透明度

        // 饼状图中间可以添加文字
        pieChart.setDrawCenterText(false);

        pieChart.setRotationAngle(0); // 初始旋转角度
        pieChart.setRotationEnabled(true); // 可以手动旋转
        pieChart.setUsePercentValues(true); // 显示成百分比
        pieChart.getDescription().setEnabled(false); // 取消右下角描述

        // 是否显示每个部分的文字描述
        pieChart.setDrawEntryLabels(false);

        // 图相对于上下左右的偏移
        pieChart.setExtraOffsets(20, 8, 75, 8);
        // 图标的背景色
        pieChart.setBackgroundColor(Color.TRANSPARENT);
        //        设置pieChart图表转动阻力摩擦系数[0,1]
        pieChart.setDragDecelerationFrictionCoef(0.75f);

        // 获取图例
        Legend legend = pieChart.getLegend();
        legend.setOrientation(Legend.LegendOrientation.VERTICAL); // 设置图例水平显示
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP); // 顶部
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT); // 右对其

        legend.setXEntrySpace(7f); // x轴的间距
        legend.setYEntrySpace(10f); // y轴的间距
        legend.setYOffset(10f); // 图例的y偏移量
        legend.setXOffset(10f); // 图例x的偏移量
        legend.setTextColor(Color.parseColor("#a1a1a1")); // 图例文字的颜色
        legend.setTextSize(13); // 图例文字的大小
    }

    /**
     * 显示饼图
     *
     * @param pieEntryList 饼图的list
     * @param colors       饼图的颜色
     */
    public void showSolidPieChart(List<PieEntry> pieEntryList, List<Integer> colors) {
        PieDataSet dataSet = new PieDataSet(pieEntryList, "");
        // 填充每个区域的颜色
        dataSet.setColors(colors);
        // 是否在图上显示数值
        dataSet.setDrawValues(true);
        //        文字的大小
        dataSet.setValueTextSize(10);
        //        文字的颜色
        dataSet.setValueTextColor(Color.BLACK);
        //        文字的样式
        dataSet.setValueTypeface(Typeface.DEFAULT_BOLD);
        //      当值位置为外边线时，表示线的前半段长度。
        dataSet.setValueLinePart1Length(0.4f);
        //      当值位置为外边线时，表示线的后半段长度。
        dataSet.setValueLinePart2Length(0.4f);
        //      当ValuePosits为OutsideDice时，指示偏移为切片大小的百分比
        dataSet.setValueLinePart1OffsetPercentage(80f);
        // 当值位置为外边线时，表示线的颜色。
        dataSet.setValueLineColor(Color.parseColor("#a1a1a1"));
        //        设置Y值的位置是在圆内还是圆外
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        //        设置Y轴描述线和填充区域的颜色一致
        //         dataSet.setUsingSliceColorAsValueLineColor(false);
        //        设置每条之前的间隙
        dataSet.setSliceSpace(1);
        // 设置饼状Item被选中时变化的距离
        dataSet.setSelectionShift(5f);
        // 填充数据
        PieData pieData = new PieData(dataSet);
        //        格式化显示的数据为%百分比
        pieData.setValueFormatter(new PercentFormatter());
        //        显示试图
        pieChart.setData(pieData);
    }
}
