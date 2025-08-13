/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.example.myandroidtestplat.ui.shareelements.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.example.myandroidtestplat.R
import com.example.myandroidtestplat.databinding.ActivityListBinding
import com.example.myandroidtestplat.ui.shareelements.data.Category
import com.example.myandroidtestplat.ui.shareelements.data.Item
import com.example.myandroidtestplat.ui.shareelements.ui.details.Details1Activity
import com.example.myandroidtestplat.ui.shareelements.util.ItemsAdapter
import com.example.myandroidtestplat.ui.shareelements.util.DataProvider
import androidx.core.util.Pair

class ShareElementsListActivity : AppCompatActivity(), ItemsAdapter.OnItemClickListener{

    var _binding:ActivityListBinding?=null
    val binding get() = _binding!!
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
      _binding=ActivityListBinding.inflate(layoutInflater)
    setContentView(binding.root)
    populateItemList(Category.LAPTOP)
  }

  override fun onItemClick(item: Item, itemView: View) {
    val detailsIntent = Intent(this, Details1Activity::class.java)
    detailsIntent.putExtra(getString(R.string.bundle_extra_item), item)

    // Start Activity with shared-transition animation
    val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
        this@ShareElementsListActivity,
        Pair.create<View, String>(
            itemView.findViewById(R.id.itemImageView),
            getString(R.string.transition_image)),
        Pair.create<View, String>(
            itemView.findViewById(R.id.itemPrice),
            getString(R.string.transition_price)))
    startActivity(detailsIntent, activityOptions.toBundle())
  }

  private fun populateItemList(category: Category) {
    val items = when (category) {
      Category.LAPTOP -> DataProvider.laptopList
      Category.MONITOR -> DataProvider.monitorList
      Category.HEADPHONE -> DataProvider.headphoneList
    }
    if (items.isNotEmpty()) {
      binding.itemsRecyclerView.adapter = ItemsAdapter(items, this)
    }
  }

}
