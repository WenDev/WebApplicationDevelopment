var entityDealList = {
  offset: 0,
  pageSize: _pageSize,
  init: function () {
    var a = this
    $('#entity-deal-list-loadmore').click(function (b) {
      b.preventDefault()
      a.loadEntityDeals()
    })
  },
  loadEntityDeals: function () {
    var b = this
    if (b.offset == 0) {$('#entity-deal-body tr.deal-item').remove()}
    var a = $('#entity-deal-body')
    $.ajax({
      url: '/deal/list',
      type: 'POST',
      data: {
        customerId: a.data('customerid'),
        contactId: a.data('contactid'),
        status: -1,
        ownerUserId: '',
        inCustomerDetailPage: '1',
        offset: b.offset
      },
      dataType: 'json',
      timeout: 60000,
      error: function (e, c, d) {alertify.alert('销售机会加载失败，请稍后再试')},
      success: function (c) {
        if (c.code == 0) {
          alertify.alert(c.message)
          return
        }
        if (c.items.deals.length == 0 && b.offset == 0) {
          $('<tr class=\'deal-item\'><td colspan=\'8\' class=\'text-center\'>没有销售机会信息</td></tr>').appendTo($('#entity-deal-body'))
          return
        }
        if (c.items.deals.length < _pageSize) {$('#entity-deal-list-loadmore').addClass('hide')} else {$('#entity-deal-list-loadmore').removeClass('hide')}
        $.each(c.items.deals, function (d, e) {
          b.showDealItem(e)
          b.offset++
        })
        if (!_isSinglePage) {$('.slidePanel-scrollable').asScrollable('update')}
      }
    })
  },
  showDealItem: function (a) {
    var c = $('#entity-deal-item-clone').clone(true).removeClass('hide').addClass('deal-item').attr('id', '')
    c.find('.deal-idx').text(this.offset + 1)
    c.find('.deal-name').text(a.name).attr('href', '/deal/detail/' + encodeURIComponent(a.encodedId))
    c.find('.deal-ownerUser').text(entity.getUserName(entity.getUser(_users, a.encodedOwnerUserId)))
    c.find('.deal-amount').text(a.formatAmount)
    c.find('.deal-closeDate').text(getFormatDate(a.closeDate, 'YYYY-MM-DD'))
    c.find('.deal-phase').text(getArrayName(_dealPhases, a.phase))
    var b = a.status
    if (b == DEAL_STATUS_LOST) {$('<span class=\'label label-danger margin-right-5\'>失败</span>').appendTo(c.find('.deal-status'))} else {if (b == DEAL_STATUS_WON) {$('<span class=\'label label-success margin-right-5\'>成功</span>').prependTo(c.find('.deal-status'))} else {$('<span class=\'label label-info margin-right-5\'>进行中</span>').prependTo(c.find('.deal-status'))}}
    c.appendTo($('#entity-deal-body'))
  }
}
$(function () {entityDealList.init()})