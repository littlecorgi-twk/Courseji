package com.littlecorgi.courseji

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.littlecorgi.commonlib.BaseActivity
import com.littlecorgi.commonlib.BaseFragment
import com.littlecorgi.commonlib.util.dip
import com.littlecorgi.courseji.databinding.ActivityMainBinding
import com.littlecorgi.courseji.schedule.vm.ScheduleViewModel
import com.littlecorgi.courseji.utils.CourseUtils
import com.tencent.bugly.beta.Beta
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * 集成运行时的MainActivity。此组件单独运行时的MainActivity是[com.littlecorgi.courseji.runalone.MainActivity]
 *
 * @author littlecorgi 2020/10/27
 */
@Route(path = "app/MainActivity")
class MainActivity : BaseActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val mViewModel by viewModels<ScheduleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Bugly升级 检测是否有新版本
        Beta.checkUpgrade()

        initViewModelData()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main_activity, MainFragment.newInstance())
            .commit()
    }

    private fun initViewModelData() {
        lifecycleScope.launch(Dispatchers.IO) {
            mViewModel.table = mViewModel.getDefaultTable()
            mViewModel.timeList = mViewModel.getTimeList(mViewModel.table.timeTable)
            // 获得当前周数
            mViewModel.currentWeek =
                CourseUtils.countWeek(mViewModel.table.startDate, mViewModel.table.sundayFirst)
            // 设置默认的选中周数
            mViewModel.selectedWeek = mViewModel.currentWeek
            // 设置列表高度
            mViewModel.itemHeight = dip(mViewModel.table.itemHeight)
        }
    }

    override fun onBackPressed() {
        val fragments = supportFragmentManager.fragments
        for (fragment in fragments) {
            // 必须是继承自 {@link com.littlecorgi.courseji.BaseFragment} 的子类才进行调用
            if (fragment is BaseFragment) {
                if (fragment.onBackPressed()) {
                    return
                }
            }
        }
        super.onBackPressed()
    }
}
